package filmnow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilmeTest {
	private Filme f;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFilmeToString() {
		this.f = new Filme("AVATAR", "", "Disney+");
		assertEquals(f.toString(), "AVATAR\nDisney+");
	}
	
	@Test
	void testFilmeToStringComAno() {
		this.f = new Filme("AVATAR", "2009", "Disney+");
		assertEquals(f.toString(), "AVATAR, 2009\nDisney+");
	}
	
	@Test
	void testFilmeToStringComHotList() {
		this.f = new Filme("AVATAR", "", "Disney+");
		f.setEhHot(true);
		assertEquals(f.toString(), "🔥 AVATAR\nDisney+");
	}
	
	@Test
	void testFilmeToStringComHotListAno() {
		this.f = new Filme("AVATAR", "2009", "Disney+");
		f.setEhHot(true);
		assertEquals(f.toString(), "🔥 AVATAR, 2009\nDisney+");
	}
	
	

}
