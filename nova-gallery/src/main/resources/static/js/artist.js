document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("createArtistForm");
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

    // Handle form submission
    form.addEventListener("submit", function(event) {
        event.preventDefault();

        const formData = new FormData(form);
        const artist = {
            name: formData.get("artistName"),
            bio: formData.get("artistBio")
        };

        fetch('/artists/artist/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(artist)
        }).then(response => {
            if (response.ok) {
                form.reset();
                fetchArtists();
            } else {
                console.error('Failed to create artist');
            }
        });
    });
});
