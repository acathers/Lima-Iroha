# Lima

The development goal of this program is to create a program that can be used in terminal or GUI to encrypt and decrypt text with weak and modern encryption as well as encrypt files with modern encryptions. See below to find out what has been added and what is scheduled to be added in the future.

Current Version: 0.7.1

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

    Caesar Cipher
    ADFGVX Cipher
    ADFGX Cipher
    Atbash Cipher
    ROT13 Cipher
    Affine Cipher
    Autokey Cipher

The following ciphers have yet to be added but in progress:

    Baconian
    Base64
    Beaufort
    Bifid
    Codes and Nomenclators
    Columnar Transposition
    Enigma Cipher
    Four-Square Cipher
    Fractionated Morse
    Hill
    Homophonic Substitution
    Lorenz
    Playfair
    Polybius Square
    Porta
    Rail-fence
    Running Key
    Simple Substitution
    Straddle Checkerboard
    Trifid
    Vigenère and Gronsfeld

    Other possible ciphers

    Four-Square
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



    Future Versions Planned (Rough Draft, subject to change.):

    Version 0.1.0 - Terminal program in beta with only Caesar ciphers
    Version 0.2.0 - Add ADFGVX
    Version 0.3.0 - Add ADFGX
    Version 0.4.0 - Add Atbash
    Version 0.5.0 - Add ROT13
    Version 0.6.0 - Add Affine
    Version 0.7.0 - Add Rail-fence
    Version 0.8.0 - Add Barconian
    Version 0.9.0 - Add Polybius Square
    Version 0.10.0 - Add Simple Substitution


    Version 1 - Release, Terminal program with 29 types of weak text encryption and decryption.

    Version 2 - GUI added

    Version 3 - Modern encryption added.

    Version 4 - File Encryption.

    Version 5 - Cipher breaker.

    Current TODO list:

    Caesar Cipher:

    Fix punctuation being encrypted.
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

    Rename.
    Logo.
    How to install and run in README.
