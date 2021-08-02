import {useEffect, useState} from "react";
import axios from "axios";

const baseUrl = process.env.REACT_APP_API_BASE_URL;

const axiosConfig = {
  headers: {
    'accept': 'application/json'
  }
};

export default function useAxiosGet(url) {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    const reqUrl = baseUrl + url;
    axios.get(reqUrl, axiosConfig)
      .then(res => setData(res.data))
      .catch(err => setError(err))
      .finally(() => setLoading(false));
  }, [url]);

  return {data, error, loading};
}