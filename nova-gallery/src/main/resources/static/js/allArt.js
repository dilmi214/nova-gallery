document.addEventListener("DOMContentLoaded", function() {
    const artList = document.getElementById("artList");

    // Function to fetch and display art
    function fetchArt() {
        fetch('/artPieces/all')
            .then(response => response.json())
            .then(data => {
                artList.innerHTML = '';
                data.forEach(artPiece => {
                    const artDiv = document.createElement('div');
                    artDiv.textContent = `${artPiece.title}: ${artPiece.description}`;
                    artList.appendChild(artDiv);
                });
            });
    }

    // Fetch artists on page load
    fetchArt();
});
