import static org.junit.Assert.*;

import org.junit.Test;

public class MazeTest {

    @Test
    public void testMaze() {
	fail("Not yet implemented");
    }

    @Test
    public void testLoadMaze() {
	Maze m= new Maze();
	assertTrue("did it work?",m.loadMaze("maze-1"));
    }

    @Test
    public void testGetNeighbors() {
	Maze m= new Maze();
	m.loadMaze("maze-2");
	System.out.println(m.getNeighbors(m.getStart()));
    }

    @Test
    public void testGetStart() {
	Maze m= new Maze();
	m.loadMaze("maze-1");
	assertEquals("the start", m.getStart().getType(), 2);
    }

    @Test
    public void testGetFinish() {
	Maze m= new Maze();
	m.loadMaze("maze-2");
	assertEquals("the finish", m.getFinish().getType(), 3);
    }

    @Test
    public void testReset() {
	fail("Not yet implemented");
    }

    @Test
    public void testToString() {
	Maze m= new Maze();
	m.loadMaze("maze-2");
	//System.out.println(m.toString());//yea it works :)
    }

    @Test
    public void testMain() {
	fail("Not yet implemented");
    }

}
