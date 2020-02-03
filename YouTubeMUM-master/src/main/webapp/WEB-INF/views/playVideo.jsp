
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>MuMTube</title>
    <link href="css/style.css"   rel="stylesheet">
</head>
<body>
<script src="js/format.js"></script>

<!-- Tab links -->
<div class="tab">
    <button class="tablinks" onclick="window.open('addNewPlaylist')">Add Playlist</button>
    <button class="tablinks" onclick="window.open('upload')">Upload Video</button>
    <button class="tablinks" onclick="window.open('allVideos')">My Playlists</button>
    <button class="tablinks" onclick="window.open('addNewPlaylist')">????Video Feedbacks</button>

</div>

<h3> Dashboard</h3>
<c:forEach var="video" items="${videos}">
    <table style="table-layout: fixed; width: 100%;" >
        <tr>
        <img src="/images/playvideo.png">
        <a href="/${video}">${video}</a>
        </tr>
    </table>
</c:forEach>
<h3> My Videos</h3>

</body>
</html>