#!/bin/bash
 cd ..
 ant &> ../compile_zad_2.txt
 CLASSPATH=.;
 cd lib

 for j in $( ls *.jar ); do
   export CLASSPATH=$CLASSPATH\;../lib/$j
 done
 
 cd ../classes
 echo $CLASSPATH
 javac Test01.java
 java Transform Test01.class &> Test01_transform_zad_2_out.txt
 java Test01 &> ../../Test01_zad_2_out.txt
 
 javac Test02.java
 java Transform Test02.class &> Test02_transform_zad_2_out.txt
 java Test02 &> ../../Test02_zad_2_out.txt
 
 javac Test03.java
 java Transform Test03.class &> Test03_transform_zad_2_out.txt
 java Test03 &> ../../Test03_zad_2_out.txt