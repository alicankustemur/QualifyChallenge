package com.alicankustemur.vngrschallenge.application;

public class TwoGen<T, Y>
{
	T	type;
	Y	type2;

	TwoGen(final T type, final Y type2)
	{
		this.type = type;
		this.type2 = type2;
	}

	T getType()
	{
		return type;
	}

	Y getType2()
	{
		return type2;
	}
}
