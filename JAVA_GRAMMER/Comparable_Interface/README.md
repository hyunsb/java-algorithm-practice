# Comparable 인터페이스

Comparable 인터페이스는 객체를 정렬하는 데 사용되는 메소드인 compareTo() 메소드를 정의하고 있습니다.

```java
public interface Comparable<T> {
    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param   o the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this object.
     */
    public int compareTo(T o);
}
```

기본적인 정렬(정수형 오름차순, String 사전순 정렬)을 구현할 때 사용합니다.

```
💡 기본적이지 않은 정렬(정수형 내림차순, String 사전 역순, 여러개의 기준으로 정렬 등) 은 `Comparator`를 사용하는 것이 일반적입니다.
```

Java에서 제공하는 정렬 가능한 클래스들은 모두 `Comparable` 인터페이스를 구현하고 있으며, 정렬 시에 이 `Comparable`에 맞게 정렬이 됩니다.


## ⭐사용방법

정렬할 객체에 `Comparable` 인터페이스를 `implements`한 후,  `compareTo()`메서드를 `override`하여 구현합니다.

### compareTo() 메서드 작성법

- 현재 객체 < 파라미터로 넘어온 객체: 음수 반환
- 현재 객체 = 파라미터로 넘어온 객체: 0 반환
- 현재 객체 > 파라미터로 넘어온 객체: 양수 반환

  반환 값이 음수 혹은 0 일 경우, 객체의 자리가 그대로 유지됩니다.

  반환 값이 양수일 경우, 두 객체의 자리가 변경 됩니다.


```java
class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x)
            return this.y - o.y;  
        else return this.x - o.x;
    }
}
```

x 값이 같은 경우 y값을 비교하여 오름차순으로 정렬하는 메서드 입니다.

x 같이 같은 경우 현재 객체의 y 값과 파라미터로 전달받은 오브젝트의 y값을 비교하여 0, 음수 혹은 양수를 반환합니다.

반환 값이 양수 일 경우, 두 객체의 자리가 변경되므로 x와 y값에 대해 오름차순으로 정렬됩니다.