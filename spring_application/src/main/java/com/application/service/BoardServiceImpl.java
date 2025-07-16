package com.application.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dao.BoardDAO;
import com.application.dto.BoardVO;

public class BoardServiceImpl implements BoardService{

	private BoardDAO boardDAO;
	private String summernotePath;
	
	
	public BoardServiceImpl(BoardDAO boardDAO,String summernotePath) {
		this.summernotePath = summernotePath;
		this.boardDAO = boardDAO;
	}

	@Override
	public List<BoardVO> list(PageMaker pageMaker) throws SQLException {
		List<BoardVO> boardList = boardDAO.selectSearchBoardList(pageMaker);
		
		int totalCount = boardDAO.selectSearchBoardListCount(pageMaker);
		pageMaker.setTotalCount(totalCount);
		
		return boardList;
	}

	@Override
	public BoardVO detail(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		return boardDAO.selectBoardByBno(bno);
	}

	@Override
	public void regist(BoardVO board) throws SQLException {
		
		int bno = boardDAO.selectBoardSeqNext();
		
		board.setBno(bno);
		
		boardDAO.insertBoard(board);		
	}

	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);		
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {		
		return boardDAO.selectBoardByBno(bno);
	}

	@Override
	public void remove(int bno) throws SQLException {
		
		BoardVO board = boardDAO.selectBoardByBno(bno);
		
		File dir = new File(summernotePath);
		File[] files = dir.listFiles();
		if(files!=null) for(File file : files) {
			if(board.getContent().contains(file.getName())) {
				file.delete();
			}
		}
		
		boardDAO.deleteBoard(bno);
	}
}