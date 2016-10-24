# JVM-anatomy

###Requirements
- JDK 1.6
- apache ant
- BCEL library

###Running

To run each of the programs go to their root directory and run:

> ant compile
> cd classes
> javac Test.java
> java -cp ".;../lib/*" Transform Test

To see if it works run:

> java Test