import java.util.*;

public class sjf{

	void ex(){

		Scanner sc=new Scanner(System.in);
		int at,bt,num,count=0,sum=0,shortest=0,time=0;
		int min=100;
		boolean check=false;
		System.out.println("Enter no. of processes:");
		num=sc.nextInt();
		process[] pr=new process[num];
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter AT and BT:");
			at=sc.nextInt();
			bt=sc.nextInt();
			pr[i]=new process("P"+(i+1),at,bt);
		}
		while(count<num)
		{
			for(int i=0;i<num;i++)
			{
				if(pr[i].AT<=time && (pr[i].remBT<min && pr[i].remBT>0))
				{
					shortest=i;
					min=pr[i].remBT;
					check=true;
				}			
			}
			if(check==false)
			{
				time++;
				continue;
			}
			pr[shortest].remBT--;
			min=pr[shortest].remBT;
			if(min==0)
			{
				min=50;
				sum=time+1;
				pr[shortest].CT=sum;
				pr[shortest].TAT=pr[shortest].CT-pr[shortest].AT;
				pr[shortest].WT=pr[shortest].TAT-pr[shortest].BT;
				count++;
				pr[shortest].display();
			}
			time++;
		}
	}
	public static void main(String[] args) {
		sjf j=new sjf();
		j.ex();
	}
}