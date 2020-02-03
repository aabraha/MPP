<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Videos</title>
</head>
<body>
<br>
<br>
<h3>List of all Videos and Playlist videos</h3>
<table>
    <tr>
        <td>

            <table border="1px" cellpadding="0" cellspacing="0" >

                <h3>List of all Videos</h3>
                     <thead>

                        <tr>
                              <th>Video Id</th>
                              <th>User Id</th>
                              <th>Likes</th>
                              <th>Dislikes</th>
                        </tr>
                     </thead>

                     <tbody>
                             <c:forEach var="video" items="${videoList}">
                                 <tr>
                                     <th>${video.videoId}</th>
                                     <td>${video.userId}</td>
                                     <td>${video.no_dislikes}</td>
                                     <td>${video.no_likes}</td>
                                </tr>
                             </c:forEach>
                    </tbody>
            </table>
        </td>
        <td>
            <!--loop through all the playlists available-->
            <h3>Playlist videos</h3>
            <c:forEach var="playlist" items="${playlistList}">

                    <table border="1px" cellpadding="0" cellspacing="0" >

                            <thead>
                                    <tr>
                                        <th>playlist Id = ${playlist.userId}</th>
                                        <th>Playlist Name  = ${playlist.playlistName}</th>
                                    </tr>
                            </thead>
                            <tbody>
                                    <c:forEach var="videos" items="${videoList}">
                                           <c:if test = "${videos.userId==playlist.userId}">
                                                    <tr>
                                                        <td>${videos.videoId}</td>
                                                        <td>${videos.userId}</td>
                                                    </tr>
                                           </c:if>
                                    </c:forEach>
                            </tbody>
                    </table>
            </c:forEach>

        </td>
    </tr>
</table>
</body>
</html>
