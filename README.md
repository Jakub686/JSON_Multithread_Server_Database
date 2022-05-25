# JSONDatabase

-MVC, Exception handling, JSON, GSON, JCommander, lombok, varargs, overloading methods

Program uses java sockets to get a jsons from clients. Jsons are stored in files on server field. Program is multithreaded and uses libraries such as google.gson API to serialize jsons and jCommander framework on client field to parse commands.

Accepted client arguments:

-t - type of server operation - get, set, delete, exit
-k - key for json storing
-v - values of json
-in - read json with properties from file
