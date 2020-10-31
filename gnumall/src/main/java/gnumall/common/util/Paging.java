package gnumall.common.util;

public class Paging {

	@SuppressWarnings("unchecked")
	public static int nextSearchingPage(int param) {

		return param;
	}

	@SuppressWarnings("unchecked")
	public static DataMap initDataMapPage(int rowMax, int pageCount, int rowCount, int nowPage){
		//rowCount : 10개씩 출력, 20개씩 출력..
		//rowMax : 출력되는 수
		// 첫 로딩시 초기화

		DataMap pageMap = new DataMap();
		pageMap.put("pageCount", pageCount);
		pageMap.put("rowCount", rowCount);
		pageMap.put("nowPage", nowPage);

		pageMap.put("rowMax", rowMax);

		// 쿼리 조회 범위 설정
		pageMap.put("startRowNum", (nowPage - 1) * rowCount + 1);
		pageMap.put("endRowNum", pageMap.getInt("startRowNum") + rowCount);
		pageMap.put("scopeRow", (nowPage - 1) * rowCount);

		int maxPage = (rowMax / rowCount + (int)(Math.ceil(rowMax % rowCount / (double)rowCount)));
		int startPage = (1 + (pageCount * (nowPage / pageCount - ((nowPage % pageCount == 0) ? 1 : 0))));
		int endPage = (startPage + pageCount - 1);
		if(endPage > maxPage) endPage = maxPage;


		pageMap.put("maxPage", maxPage);
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);



		return pageMap;
	}

	/**************************************************
	 * @MethodName : pageStartNum
	 * @Description: 페이지 시작 계산
	 * @param rowCount
	 * @param curPage
	 * @return int
	 * @Author     : joon
	 * @Version    : 2015. 4. 24.
	 **************************************************/
	public static int pageStartNum(int rowCount, int curPage){
		return (curPage - 1) * rowCount;
	}
}