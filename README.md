# Тестовое 
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
