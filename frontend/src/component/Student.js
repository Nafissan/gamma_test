import React, { useEffect, useState } from 'react';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';


export default function Student() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[nombres,setNombres]=useState([])
    const[students,setStudents]=useState([])
    const [currentGroupIndex, setCurrentGroupIndex] = useState(0); // Index du groupe actuel

    const groupSize = 5; // Taille du groupe
  
//reuperer les solutions
useEffect(()=>{
  fetch("http://localhost:8080/student/getResult")
  .then(res=>res.json())
  .then((result)=>{
    setNombres(result);
  }
)
},[])
//recuperer liste etudiants
useEffect(()=>{
  fetch("http://localhost:8080/student/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setStudents(result);
  }
)
},[])
  // Fonction pour diviser les éléments en groupes
  const groupElements = (array, size) => {
    const groups = [];
    for (let i = 0; i < array.length; i += size) {
      groups.push(array.slice(i, i + size));
    }
    return groups;
  };

  // Combiner les valeurs des deux tableaux
  const combinedArray = students.map((student, index) =>"Etudiant " + student.id + ' :  ' + nombres[index]);

  // Diviser les éléments combinés en groupes
  const groupedElements = groupElements(combinedArray, groupSize);

 // Gestionnaire de clic pour le bouton "Suivant"
 const handleNextClick = () => {
  setCurrentGroupIndex((prevIndex) => prevIndex + 1);
};

// Gestionnaire de clic pour le bouton "Précédent"
const handlePreviousClick = () => {
  setCurrentGroupIndex((prevIndex) => prevIndex - 1);
};
  return (

    <Container>
    <h1>Games</h1>

    <Paper elevation={3} style={paperStyle}>
    <h2>Slide {currentGroupIndex + 1}</h2>

          {groupedElements[currentGroupIndex] &&
            groupedElements[currentGroupIndex].map((element, i) => (
              <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}}>

              <li key={i}>{element}</li>
              </Paper>

            ))}
<div>
        <Button
          onClick={handlePreviousClick}
          disabled={currentGroupIndex === 0}
        >
          Précédent
        </Button>
        <Button
          onClick={handleNextClick}
          disabled={currentGroupIndex === groupedElements.length - 1}
        >
          Suivant
        </Button>
      </div>
    </Paper>
    </Container>
  );
}