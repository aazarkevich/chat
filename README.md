<h3> online chat </h3>
Для запуска проекта:
<ul>
    <li>Установить postgres 14</li>
    <li>Сделать restore chat.backup через pgAdmin </li>
    <li>запустить apache-tomcat-9.0.68-windows-x64\apache-tomcat-9.0.68\bin\startup.bat</li>
    <li>В resources (chat\src\main\resources) изменить <b>application.properties</b> ключ: <b>datasource.url</b> 
    на url своего сервера.</li>
    <li>В users.txt логины и пароли для авторизации.</li>
 </ul>

