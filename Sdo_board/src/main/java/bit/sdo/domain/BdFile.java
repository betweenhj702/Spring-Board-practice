package bit.sdo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BdFile {
	private long seq;
	private long b_seq; // 참조키
	private String fname;
	private String ofname;
	private long fsize;
}
