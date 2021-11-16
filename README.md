# Домашнее задание YLab university

Необходимо скачать репозторий
Собрать архив jar (pom.xml приложен)
В качестве параметров указать `-f <xml_file_path> -<mask key> <input>`
Существует 4 типа поиска: <br>
    - полный вывод всех файлов `java -jar assignment.jar -f test-files.xml` <br>
    - поиск по маске `java -jar assignment.jar -f test-files.xml -s *.java` <br>
    - поиск конкретного файла `java -jar assignment.jar -f test-files.xml -s  file-1498940214.xhtml` <br> 
    - поиск по регулярному выражению `java -jar assignment.jar -f test-files.xml -S .*?[a-z]{4}-\\d+\.[a-z]+` <br>
 <br>
Пример xml файла
---
<a href="https://imgbb.com/"><img src="https://i.ibb.co/9rsfkwv/image.png" alt="image" border="0"></a> <br>
Примеры запросов
---
<br> *полный вывод всех файлов* <br>
<a href="https://ibb.co/VN6Jq4s"><img src="https://i.ibb.co/3sK4CZn/image.png" alt="image" border="0"> <br>
<br> *поиск конкретного файла* <br>
<a href="https://ibb.co/4ZkSWCj"><img src="https://i.ibb.co/VW6CVbv/image.png" alt="image" border="0"> <br> 
<br> *поиск по маске* <br>
<a href="https://ibb.co/BThG41h"><img src="https://i.ibb.co/VMFxHKF/image.png" alt="image" border="0"><br />
<br> *поиск по регулярному выражению* <br>
<a href="https://ibb.co/SQKfsdJ"><img src="https://i.ibb.co/xmMFCf3/image.png" alt="image" border="0">
