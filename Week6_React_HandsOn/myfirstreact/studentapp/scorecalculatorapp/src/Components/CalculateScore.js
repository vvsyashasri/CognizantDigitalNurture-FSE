import React, { useState } from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore() {
  const [name, setName] = useState('');
  const [school, setSchool] = useState('');
  const [total, setTotal] = useState('');
  const [goal, setGoal] = useState('');
  const [average, setAverage] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Let's assume total is the sum of scores and goal is the number of subjects
    if (!isNaN(total) && !isNaN(goal) && Number(goal) !== 0) {
      setAverage(Number(total) / Number(goal));
    } else {
      setAverage('Invalid input');
    }
  };

  return (
    <div className="score-container">
      <h2 className="center-text">Student Score Calculator</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Student Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          className="input-field"
          required
        />
        <input
          type="text"
          placeholder="School"
          value={school}
          onChange={(e) => setSchool(e.target.value)}
          className="input-field"
          required
        />
        <input
          type="number"
          placeholder="Total Score"
          value={total}
          onChange={(e) => setTotal(e.target.value)}
          className="input-field"
          required
        />
        <input
          type="number"
          placeholder="Number of Subjects (Goal)"
          value={goal}
          onChange={(e) => setGoal(e.target.value)}
          className="input-field"
          required
        />
        <button type="submit" className="submit-btn">Calculate Average</button>
      </form>
      {average !== null && (
        <div className="result">
          <h3>Result</h3>
          {typeof average === "number" ? (
            <p>
              {name} from {school} scored an average of <b>{average.toFixed(2)}</b>
            </p>
          ) : (
            <p>{average}</p>
          )}
        </div>
      )}
    </div>
  );
}

export default CalculateScore;