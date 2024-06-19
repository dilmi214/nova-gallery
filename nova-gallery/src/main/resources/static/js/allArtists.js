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

                    // Create h2 tag for the artist name
                    const h2Tag = document.createElement('h2');

                    // Create anchor tag for the artist name
                    const aTag = document.createElement('a');
                    aTag.setAttribute('href', `artistProfile/${artist.id}`); // Add the artist ID to the URL
                    aTag.innerHTML = `${artist.name}`;

                    // Append anchor tag to h2 tag
                    h2Tag.appendChild(aTag);

                    // Append h2 tag to the artist list
                    artistList.appendChild(h2Tag);

                    artistDiv.textContent = `${artist.bio}`;
                    artistList.appendChild(artistDiv);
                });
            });
    }

    // Fetch artists on page load
    fetchArtists();
});
