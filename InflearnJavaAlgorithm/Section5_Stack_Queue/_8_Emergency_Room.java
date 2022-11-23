package InflearnJavaAlgorithm.Section5_Stack_Queue;

import java.util.*;
import java.util.stream.Collectors;

public class _8_Emergency_Room {
    public static void main(String[] args) {
        _8_Emergency_Room T = new _8_Emergency_Room();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] patients = new int[n];
        for(int i=0; i<n; i++) patients[i] = sc.nextInt();
        System.out.println(T.solution2(n, m, patients));
    }

    public int solution2(int n, int m, int[] patients){
        int answer = 1;
        Queue<Person> patientsList = new LinkedList<>();
        for(int i=0; i<n; i++)
            patientsList.offer(new Person(i, patients[i]));

        while (!patientsList.isEmpty()){
            Person tmp = patientsList.poll();
            for(Person x : patientsList){
                if(tmp.priority < x.priority){
                    patientsList.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                if(tmp.id == m) return answer;
                else answer++;
            }
        }

        return answer;
    }

    public int solution(int n, int m, int[] patients){
        Queue<Person> patientsList = new LinkedList<>();
        for(int i=0; i<n; i++)
            patientsList.offer(new Person(i, patients[i]));

        int count = 0, id = -1;
        while (id!=m){
            Person patient = patientsList.peek();

            assert patientsList.peek() != null;
            int patientId = patientsList.peek().id;

            for(Person tmp : patientsList){
                if (patient.priority < tmp.priority) {
                    patientId = tmp.id;
                    break;
                }
            }

            if(patient.id == patientId){
                patientsList.remove();
                id = patientId;
                count += 1;
            }
        }

        return count;

    }

    public class Person {
        public int id;
        public int priority;

        Person(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }
}

