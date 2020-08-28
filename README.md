# 1. Card Verification
The application was package as a jar file

## Url
<a href="https://card-verify.herokuapp.com/">Link to application</a>

## Endpoints
1. `GET` /card-scheme/verify
2. `GET` /card-scheme/stats

## Query objects
1. `GET` /card-scheme/verify 
    path variable - cardNumber `String` 
2. `GET` /card-scheme/stats 
    query params - start `Integer`, limit `Integer`
    
## Response
1. `GET` /card-scheme/verify 
```
{
    "status":String,
    "message":String,
    "error":String,
    "timestamp":String,
    "data":{
            "success":Boolean,
            "payload":{
                        "scheme":String,
                        "type":String,
                        "name":String
            }
    }
}
```
2. `GET` /card-scheme/stats 
```
{
    "status":String,
    "message":String,
    "error":String,
    "timestamp":String,
    "data":{
            "success":Boolean,
            "start":Integer,
            "limit":Integer,
            "size":Integer,
            "payload":{
                        "3848848483":Integer
             }
    }
}
```  
# 2. Encoding
The `linear` time complexiy of the algorithm is ` 0(n) `
