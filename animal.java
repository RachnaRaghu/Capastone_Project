interface animal
{
	void noise();
}

class cat implements animal 
{
	public void noise()
	{
      System.out.println("meow -meow");
	}
}
class dog implements animal 
{
	public void noise()
	{
      System.out.println("bhow-bhow");
	}
}
class snake implements animal 
{
	public void noise()
	{
      System.out.println("hiss -hiss");
	}
}
class animalsimulator
{
	void makenoise(animal arg)
	{
		arg.noise();
	}
}
class main12
{
	public static void main(String[] args) 
	{
		animalsimulator ani = new animalsimulator();
		ani.makenoise(new cat());
        ani.makenoise(new dog());
		ani.makenoise(new snake());
		System.out.println("Added this line to check my code");
		System.out.println("Added this 2nd line to check my code");
	}
}
