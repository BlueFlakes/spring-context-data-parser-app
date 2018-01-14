# java-ee-spring-context-BlueFlakes
## Documentation
### Basic routine
- #### 1. To print csv values in default format use:
    ```java -jar app.jar filename.csv```

- #### 2. To apply format inside command line use:
    java -jar app.jar ```formatName filename.csv```

  Example: ```java -jar app.jar json filename.csv```

  Available formats:
    * json
    * xml
    * table
    
### Additional functionalities ( works just when base routine is already settled )
- To set custom headers add ```+h``` command
    ##### Rules:
    - Set headers in first row inside file.
- To provide custom delimiter use ```d=``` command
- To save output inside file use ```out=file``` command and ```name=``` command
   #### Examples: 
   - Starting by ```java -jar app.jar ``` every command set
   - Just custom headers
    ```json filename.csv +h```
   - Just custom delimiter
    ```json filename.csv d=,```
   - Just file printer
    ```json filename.csv out=file name=file.txt```
   - or even mixed functionalities
    ```json filename.csv +h d=+ out=file name=file.txt```
