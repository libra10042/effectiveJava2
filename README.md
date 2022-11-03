### effective Java 2회독 study


|item|keyword|
|------|---|
|#1 생성자 대신 정적 팩터리 메서드를 고려하라|Flyweight Pattern, Bdridge Pattern|
|#2 생성자에 매개변수가 많다면 빌더를 고려하라.|Telescoping constructor pattern, Java Beans Pattern, Builder Pattern |
|#3 private 생성자나 열거 타입으로 싱글턴임을 보증하라.||
|#4 private 인스턴스화를 막으려거든 private 생성자를 사용하라.||
|#5 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라. | 의존주입 패턴, factory method Pattern, Supplier<T> |
|#6 불필요한 객체 생성은 피하라. | Adapter, 방어적 복사. |
|#7 다 쓴 객체 참조를 피하라. | Disk paging /OutOfMemoryError, 캐시와 메모리 누수, WeakHasshMap, Java callback, callback Pattern|
|#8 finailzer와 cleaner 사용을 피하라. | finalizer, cleaner, AutoCloseable, 객체 소멸자, gc algorithm |
|#9 try-finally 보다는 try-with-resource를 사용하라. ||
|#10 equals는 일반 규약을 지켜 재정의하라. | 논리적 동치성/ 대칭성/ 추이성, 리스코프 치환 원칙, AutoValue Framework |
|#11 toString을 항상 재정의하라. | |
|#12 equals를 재정의하려거든 hasCode도 재정의하라.||
|#13 clone 재정의는 주의해서 진행하라.||
|#14 Comparable을 구현할지 고려하라.||
|#15 클래스와 멤버의 접근을 최소화하라.||
|#16 public 클래스에서는 public 필드가 아닌 접근자를 메서드를 사용하라.||
|#17 변경가능성을 최소화 하라.||
|#18 아이템 상속보다 컴포지션을 사용하라.||
|#19 상속을 고려해서 설계하고 문서화하라. 그러지 않았다면 상속을 금지하라.| |
|#20 추상 클래스보다 인터페이스를 우선하라.||
|#21 인터페이스는 구현하는 쪽을 생각해 설계하라.||


참고 <Br>
[github](https://github.com/Meet-Coder-Study/book-effective-java/blob/main/README.md)
