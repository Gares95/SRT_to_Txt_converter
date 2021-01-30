# SRT to TXT Converter
This repository includes a simple Java program to convert srt files into text files to easily copy their content and paste it into some other document.

# Program Files
This repository includes the next files and folders: 
- SRT_to_TXT_converter.java: Main program that iterates thorugh _srt_ file and extracts the relevant lines of the file to write them in the _txt_ file(s). If the srt_files folder includes more than one file to convert the program will ask the user if he or she wants to convert the _srt_ file into a single _txt_ file or convert them into separated files. 
- /srt_files (folder): It includes example _srt_ files to test the program. 
- /Script/SRT_TXT_converter.sh: Unix shell script to run the _jar_ file exported from main program. 
- /Script/SRT_TXT_converter.bat: Windows batch file to run the _jar_ file exported from main program.
- /Script/SRT_TXT_converter.jar: Jar file exported from SRT_TXT_converter.java to easily test the program using SRT_TXT_converter.sh (Linux users) or SRT_TXT_converter.bat (windows users).

The program will create (if its not created yet) a folder named _txt_files_ where it will save the resulting files.

# Using Scripts
After cloning or downloading this repository you can easily execute the program using the Scripts in the /Script folder. For Linux Operating systems or Linux distributions subsystems such as MobaXterm or Git, users can use /Script/SRT_TXT_converter.sh which will execute the jar file and run the program. For Windows Operating systems users can use /Script/SRT_TXT_converter.bat. 
After copying in _srt_files_ folder the _srt_ files you wish to convert you can just double click any of these scripts and use the program.

# Examples
After executing the script converting _srt files_ in a _Single file_:
![alt text](https://raw.githubusercontent.com/Gares95/SRT_to_Txt_converter/master/Img/Single%20File.PNG)

*Note:* The resulting file is named after the first _srt_ file in _srt_files_ folder.

After executing the script converting _srt files_ in _Separated files file_:
![alt text](https://raw.githubusercontent.com/Gares95/SRT_to_Txt_converter/master/Img/Sep%20Files.PNG)