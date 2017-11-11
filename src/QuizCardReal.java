public class QuizCardReal
{
    private String question,option1,option2,option3,option4,answer;
    QuizCardReal(String q,String option,String a)
    {
        question=q;
        answer=a;
        String arr[]=option.split("/");
        option1=arr[0];
        option2=arr[1];
        option3=arr[2];
        option4=arr[3];
    }
    public String getQuestion()
    {
        return question;
    }
    public String getOptions()
    {
        return option1+"/"+option2+"/"+option3+"/"+option4;
    }
    public String getAnswer()
    {
        return answer;
    }
}
