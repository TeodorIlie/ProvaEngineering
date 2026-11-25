teodorilie@TILIE-W prova % curl -i http://localhost:8080/actuator/health
HTTP/1.1 200
Content-Type: application/vnd.spring-boot.actuator.v3+json
Transfer-Encoding: chunked
Date: Wed, 18 Nov 2026 16:35:33 GMT

{"components":{"diskSpace":{"details":{"total":494384795648,"free":334254145536,"threshold":10485760,"path":"/Users/teodorilie/Downloads/prova/.","exists":true},"status":"UP"},"livenessState":{"status":"UP"},"ping":{"status":"UP"},"readinessState":{"status":"UP"},"ssl":{"details":{"expiringChains":[],"invalidChains":[],"validChains":[]},"status":"UP"}},"groups":["liveness","readiness"],"status":"UP"}% # ProvaEngineering
