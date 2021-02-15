package bit.hibooks.mapper;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import bit.hibooks.domain.Member;

public interface MemberMapper {
	void insertMember(Member member);
	Member selectMemberInfo(Member member);
}
