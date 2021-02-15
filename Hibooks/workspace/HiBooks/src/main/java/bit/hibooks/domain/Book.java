package bit.hibooks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	private String b_itemId;
	private String b_title;
	private String b_img;
	private double b_rate;
	private String b_writer;
	private String b_publisher;
	private long b_price;
	private String b_desc;
}
