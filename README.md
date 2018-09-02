-- How --
1)Run test: mvn clean test

2)To build a report and run a local web server: mvn allure:serve

- Задача -
Дано.
Есть сервер расположенный по адресу ​ http://instatestvx.me​ (это не существующий сервер,
пишем тест на еще не имплементированный функционал)
Сервер предоставляет API авторизации - api/auth/login
Параметры запрос:
POST, application/json
login = hello@world.com
password = 12345678
Сервер обратно должен вернуть следующий JSON
{
"success": false,
"errors": {
"email": [
""
],
"password": [
""
],
"message": "The password and email you entered don't match. If you forgot your password,
use \"Forgot Password\""
}
}
Задача
Написать авто-тест, на Java, который проверит что сервер вернул, ожидаемый ответ.
Время выполнения – 4h


Результат:
тест делает проверку только одного условия "Сервер обратно должен вернуть следующий JSON".
