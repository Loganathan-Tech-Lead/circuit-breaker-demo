# circuit-breaker-demo
Run: mvn test && mvn spring-boot:run
Endpoints:
/orders/{id}/payment
/payments/{id}?mode=SUCCESS|FAILURE|SLOW
Circuit breaker config: window=5 threshold=50% wait=10s half-open=2
