## Тестовое 
>Api  возвращает реакцию на колебание валют. Если если базовая валюта выросла по отношению к отправленной пользователем то отправляется gif с тегом 'rich'
иначе отправляется gif  с тегом 'broke'
- для начала стоит зарегистрироваться и получить api key для следующих сервисов 

    - REST API курсов валют - https://docs.openexchangerates.org/
    - REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide
    
   
Конечные точки
----
  - `localhost:8080/rates` *- запрос рандом gif*
    
    | Request Parameters | Example | Description |
    | ------------- | ------------- |-------------|
    | currency: String | "EUR" | валюта для сравнения  |
    
## :whale: Запуск приложения через Docker
  ```bash
    docker build -t my_app --tag=server:latest .
    docker run -p8080:8080 my_app:latest
  ```

## Backend
----
* JDK 17

* Spring framework
  * Boot
  * Data
  
* Gradle

* Feign

* Swagger

### Тестирование

* JUnit
* Mockito
