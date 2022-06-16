package com.mycomapny.board.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycomapny.board.dto.Reply;

@Repository
public class ReplyRepositoryImpl implements ReplyRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Reply reply) {
		//1)글레벨, 글순서
		reply.setRelevel(reply.getRelevel()+1);
		reply.setRestep(reply.getRestep()+1);
		//2)글순서가 현재보다 크거나 같은데이터는 +1로수정
		
		return sqlSession.insert("com.mycomapny.board.ReplyMapper.insert",reply);
	}

	@Override
	public int update(Reply reply) {
		return sqlSession.update("com.mycomapny.board.ReplyMapper.update",reply);
	}

	@Override
	public int delete(int rnum) {
		return sqlSession.delete("com.mycomapny.board.ReplyMapper.delete",rnum);
	}

	@Override
	public Reply selectOne(int bnum) {
		return sqlSession.selectOne("com.mycomapny.board.ReplyMapper.selectOne",bnum);
	}

	@Override
	public List<Reply> selectList(int bnum) {
		return sqlSession.selectList("com.mycomapny.board.ReplyMapper.selectList",bnum);
	}

	@Override
	public int updateRestep(Reply reply) {
		// TODO Auto-generated method stub
		return  sqlSession.update("com.mycomapny.board.ReplyMapper.updateRestep",reply);
	}

}
