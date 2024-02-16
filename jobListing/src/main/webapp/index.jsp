<%@ page language="java"%>
<!DOCTYPE html>
<head>
    <title>Job Listings</title>
</head>
<body>

    <h1>Job Listings</h1>

    <div>
        <h2>Create a New Job:</h2>
        <form action="index" id="jobForm">
            <label for="profile">Profile:</label>
            <input type="text" name="profile" required><br>

            <label for="desc">Description:</label>
            <textarea name="desc" required></textarea><br>

            <label for="exp">Experience:</label>
            <input type="number" name="exp" required><br>

            <label for="techs">Technologies (comma-separated):</label>
            <input type="text" name="techs" required><br>

            <button type="submit">Create Job</button>
        </form>
    </div>

    <hr>

    <div>
        <h2>All Jobs:</h2>
        <ul>
            <c:forEach var="job" items="${allJobs}">
                <li>${job.profile} - ${job.desc} (Exp: ${job.exp} years)</li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>
