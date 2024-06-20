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

        const imageFile = document.getElementById('image').files[0];
        if (!imageFile) {
            console.error('Image file is required');
            return;
        }

        const formData = new FormData();
        formData.append('file', imageFile);

        // Upload image to Cloudinary
        fetch('/uploadImage', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (!data.url) {
                throw new Error('Failed to upload image');
            }

            // Construct the ArtPiece object
            const artPiece = {
                title: document.getElementById('title').value,
                description: document.getElementById('description').value,
                price: parseFloat(document.getElementById('price').value),
                artist: { id: parseInt(document.getElementById('artist').value) },
                imageUrl: data.url //  Cloudinary image URL
            };

            // Send the request
            return fetch('/artPieces/artPiece', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(artPiece)
            });
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to create art piece');
            }
            return response.json();
        })
        .then(data => {
            console.log('Art piece created successfully:', data);
        })
        .catch(error => console.error('Error creating art piece:', error));
    });
});
