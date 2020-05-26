#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "../../../bin" ]
then
    mkdir ../../../bin
fi

# delete output from previous run
for file in ./out/*
do
  rm $file
done

# delete differences from previous run
for file in ./differences/*
do
  rm $file
done


# compile the code into the bin folder, terminates if error occurred
if ! javac -cp ../../../src -Xlint:none -d ../../../bin ../../../src/seedu/addressbook/Main.java
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

for file in ./in/*
do
  ## get file name i.e. basename such as qcsItsAwesome.certain
  tempfile="${file##*/}"
  ## get name without extension
  name="${tempfile%.*}"

  if [ $name = 'withStorage' ]
  then
    java -classpath ../../../bin seedu.addressbook.Main addressbook.txt < $file > ./out/"$name".out
  else
    java -classpath ../../../bin seedu.addressbook.Main < $file > ./out/"$name".out
  fi

  if cmp -s ./out/"$name".out ./expected_out/"$name".out
  then
      echo "${name} - Test result: PASSED"
  else
      diff ./out/"$name".out ./expected_out/"$name".out > ./differences/"$name".out
      echo "${name} - Test result: FAILED - check differences folder for INFO"
  fi
done
