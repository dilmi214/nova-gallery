document.addEventListener("DOMContentLoaded", function() {
    // Function to fetch and display all artists
    function fetchArtists() {
        fetch('/artists')
            .then(response => response.json())
            .then(data => {
                const artistList = document.getElementById('artistList');
                artistList.innerHTML = ''; // Clear existing artists
                data.forEach(artist => {
                    const artistDiv = document.createElement('div');
                    artistDiv.textContent = `Name: ${artist.name}, Bio: ${artist.bio}`;
                    artistList.appendChild(artistDiv);
                });
            })
            .catch(error => console.error('Error fetching artists:', error));
    }

    // Fetch and display artists on page load
    fetchArtists();

    // Handle form submission to create a new artist
    const form = document.getElementById('createArtistForm');
    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const artistName = document.getElementById('artistName').value;
        const artistBio = document.getElementById('artistBio').value;

        const artist = {
            name: artistName,
            bio: artistBio
        };

        fetch('/artists/artist/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(artist)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Artist created:', data);
            fetchArtists(); // Refresh the list of artists
        })
        .catch(error => console.error('Error creating artist:', error));
    });
});
