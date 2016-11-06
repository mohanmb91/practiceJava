package main;
import java.util.*;
class GoogleDirStructSearch
{
	List<Integer> level = new ArrayList<Integer>();
	List<Boolean> level_at = new ArrayList<Boolean>();
	int getCount(String S)
	{
		String structArr[] = S.split("\n");
		int c = 0;
		for(int i=0; i<structArr.length; i++)
		{
			int t_len = structArr[i].trim().length();
			int spaces = structArr[i].length()-t_len;
			if(structArr[i].indexOf(".") == -1)
			{
				level_count(t_len+1,spaces);//+1 for '/'	
			}
			else if(!level_at.get(spaces-1))
			{
				if(structArr[i].contains("jpeg") || structArr[i].contains("png") || structArr[i].contains("gif"))
				{
					c += level.get(spaces-1);
					level_at.set(spaces-1,true);
				}
			
			}
		}
		return c;
	}
	
	void level_count(int c, int i)
	{
		int prevCount = 0;
		if(i>0)
			prevCount = level.get(i-1);
		if(level.size()<=i)
		{
			level.add(prevCount+c);
			level_at.add(false);
		}
		else
		{
			level.set(i,prevCount+c);
			level_at.set(i,false);
		}
	}
	
	public static void main(String args[])
	{
		GoogleDirStructSearch g = new GoogleDirStructSearch();
		System.out.println(g.getCount("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file.txt\ndir2\n file2.gif"));
//		String pathLists1 = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
//        String pathLists2 = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.png\ndir2\n file2.gif";
//        String pathLists3 = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n   file1.png\ndir2\n file2.gif";
//        String pathLists4 = "dir1\n dir11\n dir12\n  dir121\n  file1.txt\ndir2";
//        String pathLists5 = "";
// 
//        System.out.println("length of pathLists1 is: " + g.getCount(pathLists1));
//        System.out.println("length of pathLists2 is: " + g.getCount(pathLists2));
//        System.out.println("length of pathLists3 is: " + g.getCount(pathLists3));
//        System.out.println("length of pathLists4 is: " + g.getCount(pathLists4));
//        System.out.println("length of pathLists5 is: " + g.getCount(pathLists5));
	}
}