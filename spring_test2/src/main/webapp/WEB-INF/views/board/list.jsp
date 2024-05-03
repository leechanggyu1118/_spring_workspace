<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="container-md">
	<h1>Board list Page</h1>
	<!-- 검색라인  -->
<form action="/board/list" class="row row-cols-lg-auto g-3 align-items-center">
  <div class="col-12">
    <label class="visually-hidden" for="inlineFormInputGroupUsername">입력해주세요</label>
    <div class="input-group">
      <div class="input-group-text">
     </div>
      <input type="text" name="keyword" class="form-control" id="inlineFormInputGroupUsername" value="${ph.pgvo.keyword }" placeholder="입력해주세요.">
      <input type="hidden" name="pageNo" value="1">
      <input type="hidden" name="qty" value="10">
     
    </div>
  </div>

  <div class="col-12">
    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
    <select name="type" class="form-select" id="inlineFormSelectPref">
      <option ${ph.pgvo.type == null ? 'selected' : '' } selected>Choose...</option>
      <option value="t" ${ph.pgvo.type eq 't' ? 'selected' : '' }>Title</option>
      <option value="w"  ${ph.pgvo.type eq 'w' ? 'selected' : '' }>Writer</option>
      <option value="c"  ${ph.pgvo.type eq 'c' ? 'selected' : '' }>Content</option>
      <option value="tc"  ${ph.pgvo.type eq 'tc' ? 'selected' : '' }>title&content</option>
      <option value="wc"  ${ph.pgvo.type eq 'wc' ? 'selected' : '' }>writer&content</option>
      <option value="tw"  ${ph.pgvo.type eq 'tw' ? 'selected' : '' }>title&writer</option>
      <option value="twc" ${ph.pgvo.type eq 'twc' ? 'selected' : '' }>All</option>

    </select>
  </div>

  <div class="col-12">
<button type="submit" class="btn btn-primary position-relative">
  Search
  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    ${ph.totalCount }
    <span class="visually-hidden">unread messages</span>
  </span>
</button>
  </div>
</form> 
	<br>
	
	
	<table class="table table-dark table-sm">
		<thead>
			<tr>
				<th>bno</th>
				<th>title</th>
				<th>writer</th>
				<th>regDate</th>
				<th>readCount</th>
				<th>cmtQty</th>
				<th>hasFile</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="bvo">
		<tr>
			<td><a href="/board/detail?bno=${bvo.bno }">${bvo.bno }</a></td>
			<td> <a href="/board/detail?bno=${bvo.bno }">${bvo.title }</a> </td>
			<td>${bvo.writer }</td>
			<td>${bvo.regDate }</td>
			<td>${bvo.readCount }</td>
			<td>${bvo.cmtQty }</td>
			<td>${bvo.hasFile }</td>
		
		</tr>
		
		</c:forEach>
		
		
		</tbody>
	
	</table>
	<!-- 페이지네이션라인  -->
	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
 
    <li class="page-item ${ph.prev eq false ? 'disables' : ''}"><a class="page-link" href="/board/list?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">Previous</a></li>
  
    
    <c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
    <li class="page-item ${ph.pgvo.pageNo eq i ? 'active' : '' }"><a class="page-link" href="/board/list?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i}</a></li>
    </c:forEach>

    
  
    <li class="page-item ${ph.prev eq false ? 'disables' : ''}"><a class="page-link" href="/board/list?pageNo=${ph.endPage+1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">Next</a></li>
  
  </ul>
</nav> 
	
	
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>
