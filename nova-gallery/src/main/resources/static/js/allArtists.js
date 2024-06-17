document.addEventListener("DOMContentLoaded", function() {
    const artistList = document.getElementById("artistList");

    // Function to fetch and display artists
    function fetchArtists() {
        fetch('/artists/all')
            .then(response => response.json())
            .then(data => {
                artistList.innerHTML = '';
                data.forEach(artist => {
                    const artistDiv = document.createElement('div');
                    artistDiv.textContent = `${artist.name}: ${artist.bio}`;
                    artistList.appendChild(artistDiv);
                });
            });
    }

    // Fetch artists on page load
    fetchArtists();


});
