# 선택 정렬(Selection Sort)

Selection Sort는 해당 순서에 원소를 넣을 위치는 정해져 있으며, 어떤 원소를 넣을 지 ‘`선택`’ 하여 `교체`, `정렬`하는 알고리즘이다.

자리 선택 → 해당 자리에 오는 값 선택

### ⚙ **Process**

1. 주어진 배열 중 `최소값`을 찾는다.
2. 그 값을 정렬되어 있지 않은 위치 중 맨 앞에 위치한 값과 교체 한다. (pass)
3. 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체한다.

### ✅ **JAVA Code**

```java
public int[] selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int minIdx = i;

            for(int j=i+1; j<arr.length; j++)
                if(arr[minIdx] > arr[j])
                    minIdx = j;

            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }
```

◻**시간복잡도**

비교하는 것이 상수 시간에 이루어진다는 가정 아래, n개의 주어진 배열을 정렬하는데 O(n^2) 만큼의 시간이 걸린다. 최선, 평균, 최악의 경우 시간복잡도는 **O(n^2)** 으로 동일하다.

◻**공간복잡도**

주어진 배열 안에서 교환(swap)을 통해, 정렬이 수행되므로 **O(n)**이다.

◻**장점**

Bubble sort와 마찬가지로 알고리즘이 단순하다.

정렬을 위한 비교 횟수는 많지만, Bubble Sort에 비해 실제로 교환하는 횟수는 적기 때문에 많은 교환이 일어나야 하는 자료상태에서 비교적 효율적이다.

Bubble Sort와 마찬가지로 정렬하고자 하는 배열 안에서 교환하는 방식이므로, 다른 메모리 공간을 필요로 하지 않는다. => 제자리 정렬(in-place sorting)

◻**단점**

시간복잡도가 O(n^2)으로, 비효율적이다.

**불안정 정렬(Unstable Sort)** 이다.