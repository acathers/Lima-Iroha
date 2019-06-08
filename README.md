# Lima

The development goal of this program is to create a program that can be used in terminal or GUI to encrypt and decrypt text with weak and modern encryption as well as encrypt files with modern encryptions. See below to find out what has been added and what is scheduled to be added in the future.

Check out the webpage for Lima Security Works at limasecurityworks.io

Current Version: 0.12.0

--------------------------------------
How to run this program on Linux.
--------------------------------------

Download the repository Lima-Iroha. Once downloaded, cd to the java folder within the main folder in the program. I have the Lima-Iroha folder in /Documents/JAtom so cd for my looks like this.

/Documents/JAtom/Lima-Iroha/src/main/java

Next compile the packages with the following.

javac io/limasecurityworks/ciphers/*.java io/limasecurityworks/ui/*.java

Next run the program with the follwing.

java io/limasecurityworks/ui/Iroha

-------------------------------------

Below is a quick overview of what has been done and what still needs to be done.

The following ciphers have been added:

    Version 0.1.0 - Caesar
    Version 0.2.0 - ADFGVX
    Version 0.3.0 - ADFGX
    Version 0.4.0 - Atbash
    Version 0.5.0 - ROT13
    Version 0.6.0 - Affine
    Version 0.7.0 - Autokey
    Version 0.8.0 - Baconian
    Version 0.9.0 - Base 64
    Version 0.10.0 - Beaufort
    Version 0.11.0 - Vegenere and Gronsfeld
    Version 0.12.0 - Bifid

The following ciphers have yet to be added but in progress:

    Version 0.13.0 - Codes and Nomenclators
    Version 0.14.0 - Columnar Transposition
    Version 0.15.0 - Enigma
    Version 0.15.0 - Four-Square
    Version 0.16.0 - Fractionated Morse
    Version 0.17.0 - Hill
    Version 0.18.0 - Homophonic Substitution
    Version 0.19.0 - Lorenze
    Version 0.20.0 - Playfair
    Version 0.21.0 - Polybius Square
    Version 0.22.0 - Porta
    Version 0.23.0 - Rail-fence
    Version 0.24.0 - Running Key
    Version 0.25.0 - Simple Substitution
    Version 0.26.0 - Straddle Checkerboard
    Version 0.27.0 - Trifid

    Other possible ciphers (Probably after GUI is completed).

    Two-Square
    Alberti
    Trithemius
    Nihilist
    Solitaire
    Slidex
    Reservehandverfahren
    Reihenschieber
    Rasterschlussel 44
    One time Pad
    Kama Sutra
    DRYAD
    BATCO
    Double
    Myszkowski
    Route
    Pigpen
    Great
    ChaoCipher
    VIC cipher
    Tap code

    **Release Schedule**

    Version 1 - Release, Terminal program with 29 types of weak text encryption and decryption.

    Version 2 - GUI added

    Version 3 - Modern encryption added.

    Version 4 - File Encryption.

    Version 5 - Cipher breaker.

    Current TODO list:

    Caesar Cipher:

    Is not ignoring periods on input for encryption.

    ADFGVX:

    Fix formatting
    Add more documentation
    Add ability to quickly generate multiple new key squares.

    ADFGX:

    Fix formatting
    Add more documentation
    Add ability to quickly generate multiple new key squares.

    Affine Cipher:

    Testing for bugs.
    Update help and about commands.
