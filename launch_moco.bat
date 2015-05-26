echo off 
IF %1.==. GOTO ErreurArg 

java -jar moco-runner-0.10.1-standalone.jar http -p %1 -g global_settings.json 
GOTO End1 

:ErreurArg 
        ECHO Le parametre de port est manquant. 
        ECHO Usage: launch_moco.bat port 
        GOTO End1 
        
:End1