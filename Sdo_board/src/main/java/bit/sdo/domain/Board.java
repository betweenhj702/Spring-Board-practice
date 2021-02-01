package bit.sdo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
	private long seq;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private Date rdate;
	private long cnt;
	private long refer;
	private long lev;
	private long place;
}
