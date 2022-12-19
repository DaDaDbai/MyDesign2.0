package DS;

import dao.Patient;
import dao.disease;
import exception.noPersonFoundException;
import exception.queueEmptyException;

import java.util.LinkedList;
import java.util.List;

/**
 * @author  陆长锋 倪晨涛
 * @since JDK8
 * @throws queueEmptyException
 * 这个类管理整个医院病人的信息，采用链队列的结构
 * 这个类作为工具类存在
 *      故
 *          构造器私有
 *          采用静态方法
 *          与业务逻辑分开
 */

public class patientQueue{
    private patientQueue() {
    }

    private static int length=0;
    private static Node head=new Node(null);
        public static void add(Patient patient) {
//        在链表尾部插入一个元素
            Node newNode = new Node(patient);
//            创建新节点对象
            if(isEmpty()){
                head.setNext(newNode);
            }else {
                Node end = ergodic(length);
//                找到队尾
                end.setNext(newNode);

//            添加新节点
            }

            length++;

        }
        public static Patient pop() throws queueEmptyException {
//        返回并删除队列头部元素
            if(isEmpty()){
                throw new queueEmptyException("队列为空");
            }
            Node pop = head.getNext();
            if(pop.getNext()==null){
                length--;
                head.setNext(null);
                return pop.getPatient();
            }else {
                length--;
                head.setNext(pop.getNext());
                return pop.getPatient();
            }

        }
        public static int length(){
//         计算队列长度
            return length;
        }
        public static boolean isEmpty(){
//          判空
            return length==0;
        }
        public static Node peek() throws queueEmptyException {
//        返回队列头部元素
          if(isEmpty()){
//        如果队列为空,抛出异常
              throw new queueEmptyException("队列为空");
          }

        return ergodic(length);
        }


        private static Node ergodic(int objective){
//       这是一个私有方法，用来遍历队列，并返回我们想要查询的节点
            int i=0;
            Node temp=head;
            while (temp.getNext()!=null&&objective>i){
                temp=temp.getNext();
                i++;
            }
            return temp;
        }
        public static List<Patient> toErgodicLine(){
//        这个方法用来遍历队列,并用一个集合返回
            LinkedList<Patient> patients = new LinkedList<>();
            if(isEmpty()){
                return patients;
            }
            Node temp=head;
            while (temp.getNext()!=null){

                temp=temp.getNext();
                patients.add(temp.getPatient());
            }
            return patients;

        }
        public static  Patient select(String pId) throws noPersonFoundException {
            Node temp=head;
//                 遍历并进行判断
            int i=0;
                while (temp.getNext()!=null){
                    if(pId.equals(temp.getNext().getPatient().getpId())){
                        temp.getNext().getPatient().setPosition(i);
                        return temp.getNext().getPatient();
//                        如果找到了，就直接返回，这样后面的就都是未找到的了
                    }
                    i++;
                    temp=temp.getNext();
                }
            throw new noPersonFoundException("查无此人");


        }
        public static   void insert(Patient patient,int index){
//          这个方法，用来插入病人
            Node node = new Node(patient);
            if(isEmpty()){
//                如果队列为空
                head.setNext(node);
            }else {
                Node temp = ergodic(index - 1);
//                获取插入节点的前一个，这个地方还有待优化
                node.setNext(temp.getNext());
                temp.setNext(node);
            }
            length++;

        }
}
class Node{
//    创建的一个节点类
    private Patient patient;
    private Node next;

    public Node(Patient patient) {
        this.patient = patient;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Patient getPatient() {
        return patient;
    }

    public Node getNext() {
        return next;
    }
}


