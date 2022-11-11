package com.rb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rb.dto.DtoBoard;


public class DaoBoard {
	
	// F
	public static DaoBoard instance = new DaoBoard();
	DataSource dataSource;
	int listCount = 10; // 한페이지당 보여줄 게시물의 수
	int pageCount = 5; // 하단에 보여줄 페이지 리스트의 수
	
	// C
	public DaoBoard() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/roastbean");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// M
	public static DaoBoard getInstance() {
		return instance;
	}
	
	// List view
	public ArrayList<DtoBoard> list(int curPage) {
	       
	       //curpage를 받아서 page의 크기를 지정해주는 느낌으로 가야함
	       Connection con = null;
	       PreparedStatement pstmt = null;
	       ResultSet resultSet = null;
	        //전체 게시물의 수
	        int totalCount = 0;
	        try {
	           con = dataSource.getConnection();
	          String query = "select count(*) as total from community where community_deletedate is null ";
	          //총 게시물의 수를 구해주고 이걸 페이지마다 나눠서 보여주는 역할을 함
	          pstmt = con.prepareStatement(query);
	          resultSet = pstmt.executeQuery();
	          if(resultSet.next()) {
	             totalCount = resultSet.getInt("total");
	             System.out.println(totalCount);
	          }
	        } catch(Exception e) {
	           e.printStackTrace();
	        } finally {
	          try {
	             if(pstmt != null) pstmt.close();//게시물의 수가 null이 아닌경우 쿼리문 닫아줌
	             if(con != null) con.close();
	          } catch(Exception e2) {
	             e2.printStackTrace();
	          }
	       }
	       ArrayList<DtoBoard> dtos = new ArrayList<DtoBoard>();
	       //크기 지정을 해줘서 뽑히려는 게시물의 번호를 지정해준다.
	       
	       int nEnd = (totalCount-(curPage-1)*10);
	       System.out.println(nEnd);
	       int nStart = (nEnd-9);
	       System.out.println(nStart);

	       try {
	          con = dataSource.getConnection();
	          
	          String query = "select * from (select row_number() over(order by community_group, community_indent desc)"
	                + "as rownum, community_id, community_name, community_title, community_content, community_initdate, community_updatedate, community_deletedate, community_hit, community_group, community_step, community_indent, community_cnt "
	                + "from community where community_deletedate is null order by community_group desc, community_indent)A where rownum <= ? and rownum >= ? " ;
	          pstmt = con.prepareStatement(query);
	          pstmt.setInt(1, nEnd);//끝나는 범위를 먼저
	          pstmt.setInt(2, nStart);
	          resultSet = pstmt.executeQuery();
	          
	          while(resultSet.next()) {
	             int rownum=resultSet.getInt("rownum");
	             int community_id = resultSet.getInt("community_id");
	             String community_name = resultSet.getString("community_name");
	             String community_title = resultSet.getString("community_title");
	             String community_content = resultSet.getString("community_content");
	             String community_initdate = resultSet.getString("community_initdate");
	             String community_updatedate = resultSet.getString("community_updatedate");
	             String community_deletedate = resultSet.getString("community_deletedate");
	             int community_hit = resultSet.getInt("community_hit");
	             int community_group = resultSet.getInt("community_group");
	             int community_step = resultSet.getInt("community_step");
	             int community_indent = resultSet.getInt("community_indent");
	             int community_cnt = resultSet.getInt("community_cnt");
	             
	             DtoBoard dto = new DtoBoard(rownum, community_id, community_name, community_title, community_content, community_initdate, community_updatedate, community_deletedate, community_hit, community_group, community_step, community_indent, community_cnt);
	             dtos.add(dto);
	          }
	       } catch(Exception e) {
	          e.printStackTrace();
	       } finally {
	          try {
	             if(resultSet != null) resultSet.close();
	             if(pstmt != null) pstmt.close();
	             if(con != null) con.close();
	          } catch(Exception e2) {
	             e2.printStackTrace();
	          }
	       }
	       return dtos;
	    }
	
    // 공지사항
    public ArrayList<DtoBoard> noticeList() {
    	
    	ArrayList<DtoBoard> dtos = new ArrayList<DtoBoard>();
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
    	
    	try {
    		con = dataSource.getConnection();
    		
    		String query = "select * from community where community_name = 'admin' " +
    					   " order by community_initdate desc ";
    		pstmt = con.prepareStatement(query);
    		resultSet = pstmt.executeQuery();
    		
    		while(resultSet.next()) {
    			
    			int community_id = resultSet.getInt("community_id");
    			String community_name = resultSet.getString("community_name");
    			String community_title = resultSet.getString("community_title");
    			String community_content = resultSet.getString("community_content");
    			String community_initdate = resultSet.getString("community_initdate");
    			String community_updatedate = resultSet.getString("community_updatedate");
    			String community_deletedate = resultSet.getString("community_deletedate");
    			int community_hit = resultSet.getInt("community_hit");
    			int community_group = resultSet.getInt("community_group");
    			int community_step = resultSet.getInt("community_step");
    			int community_indent = resultSet.getInt("community_indent");
    			int community_cnt = resultSet.getInt("community_cnt");
    			
    			DtoBoard dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_updatedate, community_deletedate, community_hit, community_group, community_step, community_indent, community_cnt);
    			dtos.add(dto);
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(resultSet != null) resultSet.close();
    			if(pstmt != null) pstmt.close();
    			if(con != null) con.close();
    		} catch(Exception e2) {
    			e2.printStackTrace();
    		}
    	}
    	return dtos;
    }
	
	   // total 게시글 페이징
    public PageInfo articlePage(int curPage) {
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
    	
    	int listCount = 10;		// 한 페이지당 보여줄 게시물의 수
        int pageCount = 5;		// 하단에 보여줄 페이지 리스트의 수
        
        // 총 게시물의 수
        int totalCount = 0;
        try {
        	con = dataSource.getConnection();
        	
    		String query = "select count(*) as total from community where community_deletedate is null ";
    		pstmt = con.prepareStatement(query);
    		resultSet = pstmt.executeQuery();
    		
    		if(resultSet.next()) {
    			totalCount = resultSet.getInt("total");
    		}
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
    		try {
    			if(pstmt != null) pstmt.close();
    			if(con != null) con.close();
    		} catch(Exception e2) {
    			e2.printStackTrace();
    		}
    	}
        
        // 총 페이지 수 
        int totalPage = totalCount / listCount;
        if(totalCount % listCount > 0)
        	totalPage++;
        
        // 현재 페이지
        int myCurPage = curPage;
        if(myCurPage > totalPage)
        	myCurPage = totalPage;
        if(myCurPage < 1)
        	myCurPage = 1;
        
        // 시작 페이지
        int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
        
        // 끝 페이지
        int endPage = startPage + pageCount - 1;
        if(endPage > totalPage)
        	endPage = totalPage;
        
        PageInfo pinfo = new PageInfo();
        pinfo.setTotalCount(totalCount);
        pinfo.setListCount(listCount);
        pinfo.setTotalPage(totalPage);
        pinfo.setCurPage(curPage);
        pinfo.setPageCount(pageCount);
        pinfo.setStartPage(startPage);
        pinfo.setEndPage(endPage);
        
        return pinfo;
    }
    
	// 작성하기
    public void write(String community_name, String community_title, String community_content) {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	
    	try {
    		con = dataSource.getConnection();
    		
    		String query = "insert into community (community_name, community_title, community_content, community_hit, community_group, community_step, community_indent, community_cnt, community_initdate) " +
    					   " values(?, ?, ?, 0, (select * from(select max(community_id)+1 from community)a) ,0, 0, 0, now()) ";
    		pstmt = con.prepareStatement(query);
    		pstmt.setString(1, community_name);
    		pstmt.setString(2, community_title);
    		pstmt.setString(3, community_content);
    		pstmt.executeUpdate();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(pstmt != null) pstmt.close();
    			if(con != null) con.close();
    		} catch(Exception e2) {
    			e2.printStackTrace();
    		}
    	}
    	
    } // write end
    
    // Search
    public ArrayList<DtoBoard> bSearch(String b_opt, String keyword) {
    	
    	ArrayList<DtoBoard> dtos = new ArrayList<DtoBoard>();
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
//    	int nStart = (curPage - 1) * listCount + 1;
//    	int nEnd = (curPage - 1) * listCount + listCount;
    	
    	try {
    		con = dataSource.getConnection();
    		
    		if(b_opt.equals("1")) {
    			String query = "select * from community " + 
    						   " where community_title like '%"+ keyword +"%' or community_content like '%"+ keyword +"%' " +
    						   " order by community_initdate desc";
		 		pstmt = con.prepareStatement(query);
//		 		pstmt.setString(1, "'%"+keyword+"%'");
//		 		pstmt.setString(2, "'%"+keyword+"%'");
//		 		pstmt.setInt(3, nEnd);
//		 		pstmt.setInt(4, nStart);
		 		resultSet = pstmt.executeQuery();
		 		
		 		while(resultSet.next()) {
		 			
		 			int community_id = resultSet.getInt("community_id");
		 			String community_name = resultSet.getString("community_name");
		 			String community_title = resultSet.getString("community_title");
		 			String community_content = resultSet.getString("community_content");
		 			String community_initdate = resultSet.getString("community_initdate");
		 			int community_hit = resultSet.getInt("community_hit");
		 			int community_group = resultSet.getInt("community_group");
		 			int community_step = resultSet.getInt("community_step");
		 			int community_indent = resultSet.getInt("community_indent");
		 			int community_cnt = resultSet.getInt("community_cnt");
		 			
		 			DtoBoard dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_hit, community_group, community_step, community_indent, community_cnt);
		 			dtos.add(dto);
		 		}
    		} else if(b_opt.equals("2")) {
    			String query = "select * from community where community_title like '%"+ keyword +"%' ";
 		 		pstmt = con.prepareStatement(query);
// 		 		pstmt.setInt(2, nEnd);
// 		 		pstmt.setInt(3, nStart);
 		 		resultSet = pstmt.executeQuery();
 		 		
 		 		while(resultSet.next()) {
 		 			
 		 			int community_id = resultSet.getInt("community_id");
 		 			String community_name = resultSet.getString("community_name");
 		 			String community_title = resultSet.getString("community_title");
 		 			String community_content = resultSet.getString("community_content");
 		 			String community_initdate = resultSet.getString("community_initdate");
 		 			int community_hit = resultSet.getInt("community_hit");
 		 			int community_group = resultSet.getInt("community_group");
 		 			int community_step = resultSet.getInt("community_step");
 		 			int community_indent = resultSet.getInt("community_indent");
 		 			int community_cnt = resultSet.getInt("community_cnt");
 		 			
 		 			DtoBoard dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_hit, community_group, community_step, community_indent, community_cnt);
 		 			dtos.add(dto);
 		 		}
     		} else if(b_opt.equals("3")) {
    			String query = "select * from community where community_content like '%"+ keyword +"%' ";
  		 		pstmt = con.prepareStatement(query);
//  		 		pstmt.setInt(2, nEnd);
//  		 		pstmt.setInt(3, nStart);
  		 		resultSet = pstmt.executeQuery();
  		 		
  		 		while(resultSet.next()) {
  		 			
  		 			int community_id = resultSet.getInt("community_id");
  		 			String community_name = resultSet.getString("community_name");
  		 			String community_title = resultSet.getString("community_title");
  		 			String community_content = resultSet.getString("community_content");
  		 			String community_initdate = resultSet.getString("community_initdate");
  		 			int community_hit = resultSet.getInt("community_hit");
  		 			int community_group = resultSet.getInt("community_group");
  		 			int community_step = resultSet.getInt("community_step");
  		 			int community_indent = resultSet.getInt("community_indent");
  		 			int community_cnt = resultSet.getInt("community_cnt");
  		 			
  		 			DtoBoard dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_hit, community_group, community_step, community_indent, community_cnt);
  		 			dtos.add(dto);
  		 		}
      		} else if(b_opt.equals("4")) {
    			String query = "select * from community where community_name like '%"+ keyword +"%' ";
  		 		pstmt = con.prepareStatement(query);
//  		 		pstmt.setInt(2, nEnd);
//  		 		pstmt.setInt(3, nStart);
  		 		resultSet = pstmt.executeQuery();
  		 		
  		 		while(resultSet.next()) {
  		 			
  		 			int community_id = resultSet.getInt("community_id");
  		 			String community_name = resultSet.getString("community_name");
  		 			String community_title = resultSet.getString("community_title");
  		 			String community_content = resultSet.getString("community_content");
  		 			String community_initdate = resultSet.getString("community_initdate");
  		 			int community_hit = resultSet.getInt("community_hit");
  		 			int community_group = resultSet.getInt("community_group");
  		 			int community_step = resultSet.getInt("community_step");
  		 			int community_indent = resultSet.getInt("community_indent");
  		 			int community_cnt = resultSet.getInt("community_cnt");
  		 			
  		 			DtoBoard dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_hit, community_group, community_step, community_indent, community_cnt);
  		 			dtos.add(dto);
  		 		}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	} // Search Board End

    //-------------------------------------------
    
	// Detail Page -------------------------
	public DtoBoard contentView(String strID) {
		upHit(strID);
		DtoBoard dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = dataSource.getConnection();

			String query = "select * from community where community_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {

	             int community_id = resultSet.getInt("community_id");
	             String community_name = resultSet.getString("community_name");
	             String community_title = resultSet.getString("community_title");
	             String community_content = resultSet.getString("community_content");
	             String community_initdate = resultSet.getString("community_initdate");
	             String community_updatedate = resultSet.getString("community_updatedate");
	             String community_deletedate = resultSet.getString("community_deletedate");
	             int community_hit = resultSet.getInt("community_hit");
	             int community_group = resultSet.getInt("community_group");
	             int community_step = resultSet.getInt("community_step");
	             int community_indent = resultSet.getInt("community_indent");
	             int community_cnt = resultSet.getInt("community_cnt");

				dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_updatedate, community_deletedate, community_hit, community_group, community_step, community_indent, community_cnt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dto;
	}
	// content_view-----------------------

	// 조회수 증가
	private void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "update community set community_hit = community_hit + 1 where community_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	// 조회수-------------------------- END

	// Delete Board
	public void delete(String community_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "update community set community_deletedate = now() where community_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(community_id));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	} // End Delete Board

	// 좋아요 기능 -------------------------
	public void like(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String query = "update community set community_cnt = community_cnt + 1 where community_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
    // 좋아요 기능 END-------------------------
	
    // update board
    public void modify(String community_id, String community_title, String community_content) {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	
    	try {
    		con = dataSource.getConnection();
    		
    		String query = "update community set community_title = ?, community_content = ? where community_id = ?";
    		pstmt = con.prepareStatement(query);
//    		pstmt.setString(1, bName);
    		pstmt.setString(1, community_title);
    		pstmt.setString(2, community_content);
    		pstmt.setInt(3, Integer.parseInt(community_id));
    		pstmt.executeUpdate();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(pstmt != null) pstmt.close();
    			if(con != null) con.close();
    		} catch(Exception e2) {
    			e2.printStackTrace();
    		}
    	}
    } // Update Board
    
    
	// 답글기능 ----------------------------
	public void reply(String community_id, String community_name, String community_title, String community_content, 
			String community_group, String community_step, String community_indent) {
//		replyShape(bGroup, bStep);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String query = "insert into community (community_name, community_title, community_content, community_group, community_step, community_indent, community_initdate, community_hit, community_cnt) "
					+ " values (?, ?, ?, ?, ?, ?, now(), 0, 0)";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, community_name);
			pstmt.setString(2, community_title);
			pstmt.setString(3, community_content);
			pstmt.setInt(4, Integer.parseInt(community_group));
			pstmt.setInt(5, Integer.parseInt(community_step) + 1);
			pstmt.setInt(6, Integer.parseInt(community_indent) + 1);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
    public void replyShape(String strGroup, String strStep) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
           con = dataSource.getConnection();
           String query = "update community set community_step = community_step + 1 where community_group = ? and community_step = ?";
           pstmt = con.prepareStatement(query);
           pstmt.setInt(1, Integer.parseInt(strGroup));
           pstmt.setInt(2, Integer.parseInt(strStep));       
           pstmt.executeUpdate();
        } catch(Exception e) {
           e.printStackTrace();
        } finally {
           try {
              if(pstmt != null) pstmt.close();
              if(con != null) con.close();
           } catch(Exception e2) {
              e2.printStackTrace();
           }
        }
     }
    
    // view reply
    public DtoBoard reply_view(String str) {
    	DtoBoard dto = null;
    	
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
    	try {
    		con = dataSource.getConnection();
    		String query = "select * from community where community_id = ?";
    		pstmt = con.prepareStatement(query);
    		pstmt.setInt(1, Integer.parseInt(str));
    		resultSet = pstmt.executeQuery();
    		
    		if(resultSet.next()) {
    			
    			int community_id = resultSet.getInt("community_id");
    			String community_name = resultSet.getString("community_name");
    			String community_title = resultSet.getString("community_title");
    			String community_content = resultSet.getString("community_content");
    			String community_initdate = resultSet.getString("community_initdate");
    			int community_hit = resultSet.getInt("community_hit");
    			int community_group = resultSet.getInt("community_group");
    			int community_step = resultSet.getInt("community_step");
    			int community_indent = resultSet.getInt("community_indent");
    			int community_cnt = resultSet.getInt("community_cnt");
    			
    			dto = new DtoBoard(community_id, community_name, community_title, community_content, community_initdate, community_hit, community_group, community_step, community_indent, community_cnt);
    		}
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(pstmt != null) pstmt.close();
    			if(con != null) con.close();
    		} catch(Exception e2) {
    			e2.printStackTrace();
    		}
    	}
    	
    	return dto;
    }
    // 답글기능 ----------------------------

} // End
