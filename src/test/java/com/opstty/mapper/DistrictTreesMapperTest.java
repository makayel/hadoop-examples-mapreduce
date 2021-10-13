package com.opstty.mapper;

import com.opstty.job.DistrictTrees;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DistrictTreesMapperTest {
    @Mock
    private Mapper.Context context;
    private DistrictTreesMapper districtTrees;

    @Before
    public void setup() {
        this.districtTrees = new DistrictTreesMapper();
    }

    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "(48.857140829, 2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai Branly, avenue de " +
                "La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Oranger des Osages;" +
                ";6;Parc du";
        //String value = "miam";
        this.districtTrees.map(null, new Text(value), this.context);
        this.districtTrees.map(null, new Text(value), this.context);
        verify(this.context, times(1))
                .write(new IntWritable(7), new IntWritable(1));
    }
}
