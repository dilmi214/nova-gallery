document.addEventListener('DOMContentLoaded', function() {
    // Fetch artists and populate dropdown menu
    fetch('/artists/all')
        .then(response => response.json())
        .then(data => {
            const artistDropdown = document.getElementById('artist');
            data.forEach(artist => {
                const option = document.createElement('option');
                option.value = artist.id;
                option.text = artist.name;
                artistDropdown.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching artists:', error));

    // Handle form submission
    document.getElementById('artPieceForm').addEventListener('submit', function(event) {
        event.preventDefault();

        // Construct the ArtPiece object
        const artPiece = {
            title: document.getElementById('title').value,
            description: document.getElementById('description').value,
            price: parseFloat(document.getElementById('price').value), // Convert to number
            artist: { id: parseInt(document.getElementById('artist').value) } // Include artist ID
        };

        // Send the request
        fetch('/artPieces/artPiece', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(artPiece)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to create art piece');
            }
            return response.json();
        })
        .then(data => {
            console.log('Art piece created successfully:', data);
            // Optionally, you can redirect to another page or show a success message here
        })
        .catch(error => console.error('Error creating art piece:', error));
    });
});
