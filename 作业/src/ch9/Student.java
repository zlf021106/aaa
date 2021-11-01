package ch9;

public class Student implements Comparable<Student> {
    private String name;
    private Long xh;
    private Double score;
    public Student(String n,Long x,Double s) {
        name = n;xh = x;score = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    public String toScore() {
        return "Student [name=" + name +",xh="+ xh +",score="+ score +"]";
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
       // result = prime * result +((name == null) ? 0 : name.hashCode());
       // result = prime * result +((score == null) ? 0 : score.hashCode());
        result = prime * result +((xh == null) ? 0 : xh.hashCode());
        return result;
    }
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Student other = (Student)obj;
       // if(name == null) {
        //    if (other.name != null)
         //       return false;
         //   } else if (!name.equals(other.name))
            //    return false;
            //if(score == null) {
            //     if(other.score != null)
            //             return false;
            //    }else if(!score .equals(other.score))
            //        return false;
        if (xh == null) {
            if (other.xh != null)
                return false;
        } else if (!xh.equals(other.xh))
            return false;
        return true;
    }
    public int compareTo(Student arg0) {
        return (int) (xh - arg0.xh);
    }
}
